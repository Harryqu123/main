package seedu.learnvocabulary.testutil;

import static seedu.learnvocabulary.logic.commands.CommandTestUtil.VALID_MEANING;
import static seedu.learnvocabulary.logic.commands.CommandTestUtil.VALID_NAME_FLY;
import static seedu.learnvocabulary.logic.commands.CommandTestUtil.VALID_NAME_LEVITATE;
import static seedu.learnvocabulary.logic.commands.CommandTestUtil.VALID_TAG_ABILITY;
import static seedu.learnvocabulary.logic.commands.CommandTestUtil.VALID_TAG_FLOATING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.learnvocabulary.model.LearnVocabulary;
import seedu.learnvocabulary.model.word.Word;

/**
 * A utility class containing a list of {@code Word} objects to be used in tests.
 */
public class TypicalWords {

    public static final Word SUMO = new WordBuilder().withName("sumo")
            .withMeaning("a form of wrestling in Japan in which a contestant wins "
                    + "by forcing his opponent out of the ring or by causing him to touch"
                    + " the ground with any part of his body other than the soles of his feet, "
                    + "contestants usually being men of great height and weight.").build();
    public static final Word DELIBERATE = new WordBuilder().withName("deliberate")
            .withMeaning("carefully weighed or considered; studied; intentional: "
                    + "a deliberate lie.").build();
    public static final Word FIRE = new WordBuilder().withName("fire")
            .withMeaning("a state, process, or instance of combustion in which "
                    + "fuel or other material is ignited and combined with oxygen, "
                    + "giving off light, heat, and flame.").build();
    public static final Word VOLCANO = new WordBuilder().withName("volcano")
            .withMeaning("a vent in the earth's crust through which lava, steam, "
                    + "ashes, etc., are expelled, either continuously or at irregular intervals.").build();
    public static final Word HURRICANE = new WordBuilder().withName("hurricane")
            .withMeaning("a violent, tropical, cyclonic storm of the western North Atlantic, "
                    + "having wind speeds of or in excess of 72 miles per hour 32 m/sec.").build();
    public static final Word GLIDE = new WordBuilder().withName("glide")
            .withMeaning("to move smoothly and continuously along, as if "
                    + "without effort or resistance, as a flying bird, a boat, or a skater.").build();
    public static final Word WEIGHT = new WordBuilder().withName("weight")
            .withMeaning("the amount or quantity of heaviness or mass; amount a thing weighs.").build();

    // Manually added
    public static final Word HI = new WordBuilder().withName("hi")
            .withMeaning("used as an exclamation of greeting; hello!").build();
    public static final Word SANE = new WordBuilder().withName("sane")
            .withMeaning("free from mental derangement; having a sound, healthy mind: a sane person.")
            .build();

    // Manually added - Word's details found in {@code CommandTestUtil}
    public static final Word FLY = new WordBuilder().withName(VALID_NAME_FLY)
            .withMeaning(VALID_MEANING)
            .withTags(VALID_TAG_FLOATING).build();
    public static final Word LEVITATE = new WordBuilder().withName(VALID_NAME_LEVITATE)
            .withMeaning(VALID_MEANING)
            .withTags(VALID_TAG_ABILITY, VALID_TAG_FLOATING)
            .build();

    public static final String KEYWORD_MATCHING_GLIDE = "glide"; // A keyword that matches MEIER

    private TypicalWords() {} // prevents instantiation

    /**
     * Returns an {@code LearnVocabulary} with all the typical words.
     */
    public static LearnVocabulary getTypicalLearnVocabulary() {
        LearnVocabulary ab = new LearnVocabulary();
        for (Word word : getTypicalWords()) {
            ab.addWord(word);
        }
        return ab;
    }

    public static List<Word> getTypicalWords() {
        return new ArrayList<>(Arrays.asList(SUMO, DELIBERATE, FIRE, VOLCANO, HURRICANE, GLIDE, WEIGHT));
    }
}
