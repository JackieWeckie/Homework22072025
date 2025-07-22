package com.homework22072025.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerModel {
    private long id;
    private byte age;
    private String name;
    private String surname;
}
