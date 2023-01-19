package com.example.JOGIYO.Restaurant;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="Restaurant")
public class RestaurantDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rCode;
    @NotNull
    private String name;
    @NotNull
    private Boolean isPTSR;
    @NotNull
    private String phoneNum;

//    @OneToMany(mappedBy = "MenuDomain")
//    private List<MenuDomain> menuDomain = new ArrayList<MenuDomain>();
}
