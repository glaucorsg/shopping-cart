package br.edu.ifpb.padroes.service.impl.visitor;

import br.edu.ifpb.padroes.model.Book;
import br.edu.ifpb.padroes.model.Electronic;
import java.math.BigDecimal;

public interface Visitor {
    BigDecimal visit(Book book);
    BigDecimal visit(Electronic electronic);
}
