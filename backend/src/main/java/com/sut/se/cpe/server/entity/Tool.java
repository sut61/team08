package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@Table(name = "Tool")
public class Tool{
    @Id
    @SequenceGenerator(name = "Tool_seq", sequenceName = "Tool_seq")
    @GeneratedValue(generator = "Tool_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String tool;

    public Tool(){}

    public Tool(String tool){
        this.tool = tool;
    }
    public void setTool(String tool){
        this.tool =  tool;
    }
    public String getTool(){
        return tool;
    }
}