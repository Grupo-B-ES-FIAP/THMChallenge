package fiap.challenge.main.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fiap.challenge.main.model.Estabelecimento;
import fiap.challenge.main.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
    private static final Logger logger = LoggerFactory.getLogger(EstabelecimentoService.class);
    private final RestTemplate restTemplate;
    private final EstabelecimentoRepository repository;
    private final ObjectMapper objectMapper;
    private static final String API_URL = "https://apidadosabertos.saude.gov.br/cnes/estabelecimentos";

    @Autowired
    public EstabelecimentoService(EstabelecimentoRepository repository) {
        this.restTemplate = new RestTemplate();
        this.repository = repository;
        this.objectMapper = new ObjectMapper();
    }

    public List<Estabelecimento> fetchAndSaveEstabelecimentos(int limit, int offset) {
        try {
            String url = String.format("%s?limit=%d&offset=%d", API_URL, limit, offset);
            logger.info("Fetching data from URL: {}", url);
            
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            String responseBody = response.getBody();
            
            if (responseBody != null) {
                // Primeiro, vamos converter a resposta para um Map para ver a estrutura
                Map<String, Object> responseMap = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {});
                logger.info("Response Map: {}", responseMap);

                // A API provavelmente retorna os dados em um campo específico
                if (responseMap.containsKey("estabelecimentos")) {
                    List<Map<String, Object>> dataList = objectMapper.convertValue(
                        responseMap.get("estabelecimentos"),
                        new TypeReference<List<Map<String, Object>>>() {}
                    );
                    List<Estabelecimento> estabelecimentos = dataList.stream()
                        .map(data -> objectMapper.convertValue(data, Estabelecimento.class))
                        .toList();
                    
                    if (!estabelecimentos.isEmpty()) {
                        logger.info("Received {} estabelecimentos from API", estabelecimentos.size());
                        List<Estabelecimento> savedEstabelecimentos = repository.saveAll(estabelecimentos);
                        logger.info("Saved {} estabelecimentos to database", savedEstabelecimentos.size());
                        return savedEstabelecimentos;
                    }
                }
                logger.warn("No estabelecimentos found in API response");
            }
        } catch (Exception e) {
            logger.error("Error fetching estabelecimentos: {}", e.getMessage(), e);
        }
        
        return List.of();
    }

    public List<Estabelecimento> getAllEstabelecimentos() {
        List<Estabelecimento> estabelecimentos = repository.findAll();
        if (estabelecimentos.isEmpty()) {
            // Se não houver dados, tenta buscar da API
            return fetchAndSaveEstabelecimentos(100, 1);
        }
        return estabelecimentos;
    }

    public Estabelecimento getEstabelecimentoByCnes(Long codigoCnes) {
        return repository.findById(codigoCnes).orElse(null);
    }
} 