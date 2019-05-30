package com.x.ess.dao;

import com.x.ess.dao.others.BookAvailability;
import com.x.ess.dao.others.BookCategory;
import com.x.ess.dao.others.Author;
import com.x.ess.dao.others.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@TypeAlias("Book")
public class Book extends GenericDao {

    @Id
    private String id;
    private String name;
    private Author author;
    private String description;
    private String keyWords;
    private Date releaseDate;
    private BookAvailability bookavailability;
    private BookCategory bookcategory;

}
