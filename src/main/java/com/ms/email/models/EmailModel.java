package com.ms.email.models;

import com.ms.email.enumerations.Situation;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "EMAIL")
public class EmailModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ownerRef;

    private String emailFrom;

    private String emailTo;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String body;

    private LocalDateTime sendDate;

    @Enumerated(EnumType.STRING)
    private Situation situation;
}
