package com.flamexander.hibernate.crud;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.concurrent.locks.ReentrantLock;

@Entity
@Table(name = "simple_items")
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//@Where(clause = "price > 10")
//@FilterDef(
//        name="bigPrice",
//        parameters = @ParamDef(
//                name="price_param",
//                type="integer"
//        )
//)
//@Filter(
//        name="bigPrice",
//        condition="price > :price_param"
//)
//@DynamicUpdate
@NamedQueries({
                      @NamedQuery(name = "byIdSelect", query = "select s from SimpleItem s where s.id = :id")
              })
public class SimpleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SimpleItem() {
    }

    public SimpleItem(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public SimpleItem(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("SimpleItem [id = %d, title = %s, price = %d]", id, title, price);
    }
}

