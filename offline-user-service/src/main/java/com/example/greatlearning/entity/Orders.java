package com.example.greatlearning.entity;

import com.example.greatlearning.model.JpaConverterJson;
import com.example.greatlearning.model.Order;
import com.example.greatlearning.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column
   Long id;

   @Column(columnDefinition = "date default sysdate")
   @Temporal(TemporalType.DATE)
   private Date bookingDate;


   @Enumerated(EnumType.STRING)
   @Column
   private PaymentMode paymentMode;

   @Column
   @Convert(converter = JpaConverterJson.class)
   private List<Order> items;

   @Column
   private String feedbackComments;

   @Column
   private Integer rating;

   @Column
   private Boolean paymentStatus;

}
