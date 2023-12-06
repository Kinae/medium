package eu.kinae;

public record Person(String id, String civility, String lastName, String firstName) {
    public Person {
        if(id == null) {
            throw new IllegalArgumentException("id should not be null");
        }

        if(civility == null) {
            throw new IllegalArgumentException("civility should not be null");
        }

        if(lastName == null) {
            throw new IllegalArgumentException("lastName should not be null");
        }

        if(firstName == null) {
            throw new IllegalArgumentException("firstName should not be null");
        }
    }
}
