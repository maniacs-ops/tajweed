package com.quran.tajweed.rule;

import com.quran.tajweed.model.Result;
import com.quran.tajweed.model.ResultType;
import com.quran.tajweed.util.CharacterUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Ghunna Rule
 * Occurs when a noon shadda or meem shadda appears
 */
public class GhunnaRule implements Rule {

    @Override
    public List<Result> checkAyah(String ayah){
        List<Result> results = new ArrayList<>();

        int length = ayah.length();
        int startPos = 0, endPos = 0;
        for (int i = 0; i < length; i++){
            int[] previous = {0, 0, 0, 0, 0};
            int[] next = {0, 0, 0, 0, 0};
            for (int j = 0; j < previous.length; j++){
                int nIndex = i + j + 1;
                int pIndex = i - j - 1;
                if(nIndex < length){
                    next[j] = ayah.codePointAt(nIndex);
                }
                if(pIndex >= 0){
                    previous[j] = ayah.codePointAt(pIndex);
                }
            }
            int currentChar = ayah.codePointAt(i);
            if ((currentChar == CharacterUtil.NOON ||
                 currentChar == CharacterUtil.MEEM) &&
                 (next[0] == CharacterUtil.SHADDA ||
                 next[1] == CharacterUtil.SHADDA)){

                startPos = i - findPreviousLetterPronounced(previous);
                endPos = i + findNextLetter(next);
                results.add(new Result(ResultType.GHUNNA, startPos, endPos));
            }
        }
        return results;
    }

    private int findPreviousLetterPronounced (int[] previous){
        for (int i = 1; i < previous.length; i++){
            if(CharacterUtil.isLetter(previous[i]) && CharacterUtil.isDiaMark(previous[i-1])){
                return i;
            }
        }
        return 0;
    }

    private int findNextLetter (int[] next) {
        for (int i = 0; i < next.length; i++){
            if(!CharacterUtil.isDiaMark(next[i])){
                return i;
            }
        }
        return 0;
    }
}
