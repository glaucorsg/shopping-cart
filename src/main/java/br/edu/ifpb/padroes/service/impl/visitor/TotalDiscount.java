package br.edu.ifpb.padroes.service.impl.visitor;

import java.math.BigDecimal;
import br.edu.ifpb.padroes.model.Book;
import br.edu.ifpb.padroes.model.Electronic;
import br.edu.ifpb.padroes.model.Product;
import java.util.Map;


public class TotalDiscount implements Visitor {

    private static final BigDecimal BOOK_DISCOUNT = BigDecimal.valueOf(0.3); // 30 %
    private static final BigDecimal ELECTRONIC_DISCOUNT = BigDecimal.valueOf(0.05); // 5 %
    

    public BigDecimal calcDiscount(Map<Product, Integer> products) {
        return products.keySet().stream().map(product -> product.accept(this).multiply(BigDecimal.valueOf(products.get(product)))).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    @Override
    public BigDecimal visit(Book book) {
        return book.getPrice().multiply(BOOK_DISCOUNT);
    }

    @Override
    public BigDecimal visit(Electronic electronic) {
        return electronic.getPrice().multiply(ELECTRONIC_DISCOUNT);
    }
}