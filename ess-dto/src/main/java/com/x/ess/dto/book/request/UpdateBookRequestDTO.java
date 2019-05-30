package com.x.ess.dto.book.request;

import com.x.ess.dao.others.BookAvailability;
import com.x.ess.dao.others.BookCategory;
import com.x.ess.dao.others.Author;
import com.x.ess.dto.basic.UpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBookRequestDTO implements UpdateDTO {

    private String name;
    private Author author;
    private String description;
    private String keyWords;
    private Date releaseDate;
    private BookCategory bookcategory;
    private BookAvailability bookavailability;
}
