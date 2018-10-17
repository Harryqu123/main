package seedu.learnvocabulary.ui.testutil;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import guitests.guihandles.ResultDisplayHandle;
import guitests.guihandles.WordCardHandle;
import guitests.guihandles.WordListPanelHandle;
import seedu.learnvocabulary.model.word.Word;
import seedu.learnvocabulary.ui.WordCard;

/**
 * A set of assertion methods useful for writing GUI tests.
 */
public class GuiTestAssert {
    private static final String LABEL_DEFAULT_STYLE = "label";
    /**
     * Asserts that {@code actualCard} displays the same values as {@code expectedCard}.
     */
    public static void assertCardEquals(WordCardHandle expectedCard, WordCardHandle actualCard) {
        assertEquals(expectedCard.getId(), actualCard.getId());
        assertEquals(expectedCard.getName(), actualCard.getName());
        assertEquals(expectedCard.getTags(), actualCard.getTags());

        expectedCard.getTags().forEach(tag ->
                assertEquals(expectedCard.getTagStyleClasses(tag), actualCard.getTagStyleClasses(tag)));
    }

    /**
     * Asserts that {@code actualCard} displays the details of {@code expectedWord}.
     */
    public static void assertCardDisplaysWord(Word expectedWord, WordCardHandle actualCard) {
        assertEquals(expectedWord.getName().fullName, actualCard.getName());

        assertTagsEqual(expectedWord, actualCard);
    }

    /**
     * Returns the color style for {@code tagName}'s label. The tag's color is determined by looking up the color
     * in {@code WordCard#TAG_COLOR_STYLES}, using an index generated by the hash code of the tag's content.
     *
     * @see WordCard#getTagColorStyleFor(String)
     */
    private static String getTagColorStyleFor(String tagName) {
        switch (tagName) {
        case "toLearn":
        case "justAdded":
            return "teal";
        case "birds":
        case "animals":
        case "floating":
            return "yellow";

        case "complicated":
        case "difficult":
            return "orange";

        case "easy":
            return "brown";

        case "usable":
            return "grey";
        default:
            throw new AssertionError(tagName + " does not have a color assigned.");
        }
    }

    /**
     * Asserts that the tags in {@code actualCard} matches all the tags in {@code expectedWord} with the correct
     * color.
     */
    private static void assertTagsEqual(Word expectedWord, WordCardHandle actualCard) {
        List<String> expectedTags = expectedWord.getTags().stream()
                .map(tag -> tag.tagName).collect(Collectors.toList());
        assertEquals(expectedTags, actualCard.getTags());
        expectedTags.forEach(tag ->
                assertEquals(Arrays.asList(LABEL_DEFAULT_STYLE, getTagColorStyleFor(tag)),
                        actualCard.getTagStyleClasses(tag)));
    }

    /**
     * Asserts that the list in {@code wordListPanelHandle} displays the details of {@code words} correctly and
     * in the correct order.
     */
    public static void assertListMatching(WordListPanelHandle wordListPanelHandle, Word... words) {
        for (int i = 0; i < words.length; i++) {
            wordListPanelHandle.navigateToCard(i);
            assertCardDisplaysWord(words[i], wordListPanelHandle.getWordCardHandle(i));
        }
    }

    /**
     * Asserts that the list in {@code wordListPanelHandle} displays the details of {@code words} correctly and
     * in the correct order.
     */
    public static void assertListMatching(WordListPanelHandle wordListPanelHandle, List<Word> words) {
        assertListMatching(wordListPanelHandle, words.toArray(new Word[0]));
    }

    /**
     * Asserts the size of the list in {@code wordListPanelHandle} equals to {@code size}.
     */
    public static void assertListSize(WordListPanelHandle wordListPanelHandle, int size) {
        int numberOfPeople = wordListPanelHandle.getListSize();
        assertEquals(size, numberOfPeople);
    }

    /**
     * Asserts the message shown in {@code resultDisplayHandle} equals to {@code expected}.
     */
    public static void assertResultMessage(ResultDisplayHandle resultDisplayHandle, String expected) {
        assertEquals(expected, resultDisplayHandle.getText());
    }
}
