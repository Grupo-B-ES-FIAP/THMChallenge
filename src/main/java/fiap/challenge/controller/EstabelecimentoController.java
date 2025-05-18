package fiap.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fiap.challenge.main.model.Estabelecimento;
import fiap.challenge.main.service.EstabelecimentoService;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentoController {

    private final EstabelecimentoService service;

    @Autowired
    public EstabelecimentoController(EstabelecimentoService service) {
        this.service = service;
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Estabelecimento>> fetchEstabelecimentos(
            @RequestParam(defaultValue = "100") int limit,
            @RequestParam(defaultValue = "1") int offset) {
        return ResponseEntity.ok(service.fetchAndSaveEstabelecimentos(limit, offset));
    }

    @GetMapping
    public ResponseEntity<List<Estabelecimento>> getAllEstabelecimentos() {
        return ResponseEntity.ok(service.getAllEstabelecimentos());
    }

    @GetMapping("/{codigoCnes}")
    public ResponseEntity<Estabelecimento> getEstabelecimentoByCnes(@PathVariable Long codigoCnes) {
        Estabelecimento estabelecimento = service.getEstabelecimentoByCnes(codigoCnes);
        if (estabelecimento != null) {
            return ResponseEntity.ok(estabelecimento);
        }
        return ResponseEntity.notFound().build();
    }
} 