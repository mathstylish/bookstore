package br.com.bookstore.domain.order;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ManyToOne
    @JoinColumn
    private Shipper shipper;

    @Enumerated(EnumType.STRING)
    private StateOrder state;
}