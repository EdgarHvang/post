package edu.miu.post.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class Localization {
    @Autowired
    Environment env;

    @Autowired
    MessageSource messageSource;

    public String getMessage(String messageKey) {
        return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
    }

    public String getMessage(String messageKey, Object[] obj) {
        return messageSource.getMessage(messageKey, obj, LocaleContextHolder.getLocale());
    }
}
