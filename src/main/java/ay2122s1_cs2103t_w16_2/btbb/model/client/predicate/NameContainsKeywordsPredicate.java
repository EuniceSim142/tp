package ay2122s1_cs2103t_w16_2.btbb.model.client.predicate;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import ay2122s1_cs2103t_w16_2.btbb.model.client.Client;

/**
 * Tests that a {@code Client}'s {@code Name} matches any of the keywords given.
 */
public class NameContainsKeywordsPredicate implements Predicate<Client> {
    private final List<String> keywords;

    public NameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Client client) {
        String lowercaseName = client.getName().toString().toLowerCase(Locale.ROOT);
        return keywords.stream()
                .anyMatch(keyword -> lowercaseName.contains(keyword.toLowerCase(Locale.ROOT)));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((NameContainsKeywordsPredicate) other).keywords)); // state check
    }
}
