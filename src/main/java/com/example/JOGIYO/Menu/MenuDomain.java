package com.example.JOGIYO.Menu;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="Menu")
public class MenuDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mCode;
    @NotNull
    private String name;
    @NotNull
    private int price;
    @NotNull
    private int sequence;

//    @ManyToOne
//    @JoinColumn(name="rCode")
//    private RestaurantDomain restaurantDomain;
}
