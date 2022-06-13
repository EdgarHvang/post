package edu.miu.post.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewPostRequest {

    @NotBlank(message = "{val.not.null}")
    @Length(min = 1, max = 100 ,message = "{val.length}")
    private String title;

    @Nullable
    @Length(min = 1, max = 100 ,message = "{val.length}")
    private String picture;

    @NotBlank(message = "{val.not.null}")
    @Length(min = 3, max = 500, message = "{val.length}")
    private String content;

}
