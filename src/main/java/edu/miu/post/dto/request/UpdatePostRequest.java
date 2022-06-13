package edu.miu.post.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostRequest {

    private String title;

    private String picture;

    private String content;

    private Long id;
}
