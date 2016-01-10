package com.quran.tajweed;

import com.quran.tajweed.model.Result;
import com.quran.tajweed.model.TajweedRule;

import java.util.ArrayList;
import java.util.List;

public class TajweedRules {

  public static void main (String args[]) {
    String[] text = new String[] {
      "الْحَمْدُ لِلَّهِ رَبِّ الْعَالَمِينَ",
      "ذَٰلِكَ الْكِتَابُ لَا رَيْبَ ۛ فِيهِ ۛ هُدًى لِّلْمُتَّقِينَ",
      "تَبَّتْ يَدَا أَبِي لَهَبٍ وَتَبَّ",
      "ثُمَّ بَعَثْنَاكُم مِّن بَعْدِ مَوْتِكُمْ لَعَلَّكُمْ تَشْكُرُونَ",
    };

    List<TajweedRule> rules = TajweedRule.RULES;
    for (String ayahText : text) {
      System.out.println("Considering: " + ayahText);
      List<Result> results = new ArrayList<>();
      for (TajweedRule tajweedRule : rules) {
        results.addAll(tajweedRule.rule.checkAyah(ayahText));
      }

      for (Result result : results) {
        System.out.println("matched " + result.resultType.debugName +
            " at " + result.start + " to " + result.ending);
      }
    }
  }
}
