package com.qifei.mapstruct;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-25T10:05:45+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class Person2UserMapperImpl implements Person2UserMapper {

    @Override
    public PersonDO user2Person(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        PersonDO personDO = new PersonDO();

        personDO.setName( userDO.getUserName() );
        personDO.setAge( userDO.getAge() );

        personDO.setHasChild( new Person2UserUtils().convertInt2Bool(userDO.getHasChild()) );

        return personDO;
    }
}
