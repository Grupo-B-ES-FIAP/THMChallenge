package fiap.challenge.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Estabelecimento {
    @Id
    @JsonProperty("codigo_cnes")
    private Long codigoCnes;
    
    @JsonProperty("numero_cnpj_entidade")
    private String numeroCnpjEntidade;
    
    @JsonProperty("nome_razao_social")
    private String nomeRazaoSocial;
    
    @JsonProperty("nome_fantasia")
    private String nomeFantasia;
    
    @JsonProperty("natureza_organizacao_entidade")
    private String naturezaOrganizacaoEntidade;
    
    @JsonProperty("tipo_gestao")
    private String tipoGestao;
    
    @JsonProperty("descricao_nivel_hierarquia")
    private String descricaoNivelHierarquia;
    
    @JsonProperty("descricao_esfera_administrativa")
    private String descricaoEsferaAdministrativa;
    
    @JsonProperty("codigo_tipo_unidade")
    private Integer codigoTipoUnidade;
    
    @JsonProperty("codigo_cep_estabelecimento")
    private String codigoCepEstabelecimento;
    
    @JsonProperty("endereco_estabelecimento")
    private String enderecoEstabelecimento;
    
    @JsonProperty("numero_estabelecimento")
    private String numeroEstabelecimento;
    
    @JsonProperty("bairro_estabelecimento")
    private String bairroEstabelecimento;
    
    @JsonProperty("numero_telefone_estabelecimento")
    private String numeroTelefoneEstabelecimento;
    
    @JsonProperty("latitude_estabelecimento_decimo_grau")
    private Double latitudeEstabelecimentoDecimoGrau;
    
    @JsonProperty("longitude_estabelecimento_decimo_grau")
    private Double longitudeEstabelecimentoDecimoGrau;
    
    @JsonProperty("endereco_email_estabelecimento")
    private String enderecoEmailEstabelecimento;
    
    @JsonProperty("numero_cnpj")
    private String numeroCnpj;
    
    @JsonProperty("codigo_identificador_turno_atendimento")
    private String codigoIdentificadorTurnoAtendimento;
    
    @JsonProperty("descricao_turno_atendimento")
    private String descricaoTurnoAtendimento;
    
    @JsonProperty("estabelecimento_faz_atendimento_ambulatorial_sus")
    private String estabelecimentoFazAtendimentoAmbulatorialSus;
    
    @JsonProperty("codigo_estabelecimento_saude")
    private String codigoEstabelecimentoSaude;
    
    @JsonProperty("codigo_uf")
    private Integer codigoUf;
    
    @JsonProperty("codigo_municipio")
    private Integer codigoMunicipio;
    
    @JsonProperty("descricao_natureza_juridica_estabelecimento")
    private String descricaoNaturezaJuridicaEstabelecimento;
    
    @JsonProperty("codigo_motivo_desabilitacao_estabelecimento")
    private String codigoMotivoDesabilitacaoEstabelecimento;
    
    @JsonProperty("estabelecimento_possui_centro_cirurgico")
    private Integer estabelecimentoPossuiCentroCirurgico;
    
    @JsonProperty("estabelecimento_possui_centro_obstetrico")
    private Integer estabelecimentoPossuiCentroObstetrico;
    
    @JsonProperty("estabelecimento_possui_centro_neonatal")
    private Integer estabelecimentoPossuiCentroNeonatal;
    
    @JsonProperty("estabelecimento_possui_atendimento_hospitalar")
    private Integer estabelecimentoPossuiAtendimentoHospitalar;
    
    @JsonProperty("estabelecimento_possui_servico_apoio")
    private Integer estabelecimentoPossuiServicoApoio;
    
    @JsonProperty("estabelecimento_possui_atendimento_ambulatorial")
    private Integer estabelecimentoPossuiAtendimentoAmbulatorial;
    
    @JsonProperty("codigo_atividade_ensino_unidade")
    private String codigoAtividadeEnsinoUnidade;
    
    @JsonProperty("codigo_natureza_organizacao_unidade")
    private String codigoNaturezaOrganizacaoUnidade;
    
    @JsonProperty("codigo_nivel_hierarquia_unidade")
    private String codigoNivelHierarquiaUnidade;
    
    @JsonProperty("codigo_esfera_administrativa_unidade")
    private String codigoEsferaAdministrativaUnidade;
    
    @JsonProperty("data_atualizacao")
    private String dataAtualizacao;
} 