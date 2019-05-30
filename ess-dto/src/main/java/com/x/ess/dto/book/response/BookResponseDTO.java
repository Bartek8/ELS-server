package com.x.ess.dto.book.response;


import com.x.ess.dao.others.BookAvailability;
import com.x.ess.dao.others.BookCategory;
import com.x.ess.dao.others.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponseDTO {

    private String id;
    private String name;
    private Author author;
    private String description;
    private String keyWords;
    private Date releaseDate;
    private BookCategory bookcategory;
    private BookAvailability bookavailability;
    private boolean removed;
}