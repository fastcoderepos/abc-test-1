package com.fastcode.aaaloc.domain.core.staff;

import javax.persistence.*;
import java.time.*;
import com.fastcode.aaaloc.domain.core.address.AddressEntity;
import com.fastcode.aaaloc.domain.core.store.StoreEntity;
import com.fastcode.aaaloc.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class StaffEntity extends AbstractEntity {

    @Basic
    @Column(name = "last_name", nullable = false,length =45)
    private String lastName;

    @Basic
    @Column(name = "active", nullable = false)
    private Boolean active;
    
    @Basic
    @Column(name = "store_id", nullable = false)
    private Short storeId;
    
    @Basic
    @Column(name = "first_name", nullable = false,length =45)
    private String firstName;

    @Basic
    @Column(name = "password", nullable = true,length =40)
    private String password;

    @Basic
    @Column(name = "last_update", nullable = true)
    private LocalDateTime lastUpdate;

    @Basic
    @Column(name = "email", nullable = true,length =50)
    private String email;

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id", nullable = false)
    private Integer staffId;
    
    @Basic
    @Column(name = "username", nullable = false,length =16)
    private String username;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToOne(mappedBy = "staff", cascade=CascadeType.MERGE)
    private StoreEntity store;

}



