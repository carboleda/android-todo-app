package co.devhack.todoapp;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;

/**
 * Created by krlosf on 28/08/17.
 */

public class Utilities {
    /**
     *
     * @param text
     * @return
     */
    public static SpannableStringBuilder strikeText(String text) {
        return strikeText(text, 0, text.length());
    }

    /**
     * @source https://android--examples.blogspot.com.co/2016/08/android-spannable-strikethrough-text.html
     * @param text
     * @param start
     * @param end
     * @return
     */
    public static SpannableStringBuilder strikeText(String text, int start, int end) {
        // Initialize a new SpannableStringBuilder instance
        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(text);

        // Initialize a new StrikeThroughSpan to display strike through text
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();

        // Apply the strike through text to the span
        ssBuilder.setSpan(
                strikethroughSpan, // Span to add
                start, // Start of the span (inclusive)
                end, // End of the span (exclusive)
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE // Do not extend the span when text add later
        );

        return ssBuilder;
    }
}
