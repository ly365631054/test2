package org.custom;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author yong.li_1
 **/

@Data
@AllArgsConstructor
public class User {

    private String id;

    private String username;

    private String password;

    private String salt;
}
