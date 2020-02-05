package com.embl.ebi.person.exeption;

public class PersonDoesNotExistException extends Exception
{
    private static final long serialVersionUID = 1L;

    public PersonDoesNotExistException(Long id) {
        super("person not found : " + id);
    }
}
