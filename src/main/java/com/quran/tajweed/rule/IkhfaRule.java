package com.quran.tajweed.rule;

import com.quran.tajweed.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Ikhfa Rule
 * Ikhafa occurs when a ن (noon sakina) or tanween are followed by any letter, except for:
 * - the letters of idgham (يرملون)
 * - the letter of iqlab (ب)
 * - the letters of izhar ء ه ع ح غ خ
 */
public class IkhfaRule implements Rule {

  @Override
  public List<Result> checkAyah(String ayah) {
    return new ArrayList<>();
  }
}
