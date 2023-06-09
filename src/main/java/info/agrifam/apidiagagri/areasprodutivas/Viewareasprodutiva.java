package info.agrifam.apidiagagri.areasprodutivas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "viewareasprodutivas")
public class Viewareasprodutiva {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "idcaracterizacao", nullable = false)
    private Integer idcaracterizacao;

    @Size(max = 50)
    @NotNull
    @Column(name = "descarea", nullable = false, length = 50)
    private String descarea;

    @NotNull
    @Column(name = "tamanhoha", nullable = false, precision = 10, scale = 2)
    private BigDecimal tamanhoha;

    @NotNull
    @Column(name = "upfidproduto", nullable = false)
    private Integer upfidproduto;

    @NotNull
    @Column(name = "idmobile", nullable = false)
    private Integer idmobile;

    @Size(max = 255)
    @Column(name = "login")
    private String login;

    @Column(name = "dtpreparosolo")
    private Instant dtpreparosolo;

    @Column(name = "dtestimadacolheita")
    private Instant dtestimadacolheita;

    @Column(name = "dtalteracao")
    private Instant dtalteracao;

    @NotNull
    @Column(name = "dtcreated", nullable = false)
    private Instant dtcreated;

    @Column(name = "identificacaoid")
    private Integer identificacaoid;

    @Column(name = "stcancelado")
    private Character stcancelado;

    @Size(max = 2)
    @Column(name = "upfuf", length = 2)
    private String upfuf;

    @Column(name = "munid")
    private Integer munid;

    @Size(max = 45)
    @Column(name = "upfnmproduto", length = 45)
    private String upfnmproduto;

    @Column(name = "idcomunidade")
    private Integer idcomunidade;

    @Column(name = "pessoaid")
    private Integer pessoaid;

    @Column(name = "fazdownload")
    private Character fazdownload;

    @Size(max = 32)
    @Column(name = "logindownload", length = 32)
    private String logindownload;

    @Size(max = 200)
    @NotNull
    @Column(name = "pesnm", nullable = false, length = 200)
    private String pesnm;

}