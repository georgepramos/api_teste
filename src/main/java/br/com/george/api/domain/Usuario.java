package br.com.george.api.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
/*@Getter
@Setter
@EqualsAndHashCode
@ToString*/

@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column(unique = true)
    private String email;

    @Column
    private String senha;
}
