package br.edu.ifpb.padroes.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import br.edu.ifpb.padroes.service.impl.visitor.Visitor;

@Entity
@DiscriminatorValue("electronic")
public class Electronic extends Product {
    @Override
    public BigDecimal accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
