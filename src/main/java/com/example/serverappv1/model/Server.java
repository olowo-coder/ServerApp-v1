package com.example.serverappv1.model;
/*
  *@author Olowo
  * @version 1.0
  * @since 1/02/2022
 */


import com.example.serverappv1.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "server")
public class Server {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String id;
    @Indexed(unique=true)
    @NotEmpty(message = "IP address cannot be empty or null")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;
}
