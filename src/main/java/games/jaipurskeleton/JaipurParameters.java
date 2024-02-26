package games.jaipurskeleton;

import core.AbstractGameState;
import core.AbstractParameters;
import games.jaipurskeleton.components.JaipurCard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>This class should hold a series of variables representing game parameters (e.g. number of cards dealt to players,
 * maximum number of rounds in the game etc.). These parameters should be used everywhere in the code instead of
 * local variables or hard-coded numbers, by accessing these parameters from the game state via {@link AbstractGameState#getGameParameters()}.</p>
 *
 * <p>It should then implement appropriate {@link #_copy()}, {@link #_equals(Object)} and {@link #hashCode()} functions.</p>
 *
 * <p>The class can optionally extend from {@link evaluation.optimisation.TunableParameters} instead, which allows to use
 * automatic game parameter optimisation tools in the framework.</p>
 */
public class JaipurParameters extends AbstractParameters {
    Map<JaipurCard.GoodType, Integer> goodNCardsMinimumSell = new HashMap<JaipurCard.GoodType, Integer>() {{
        put(JaipurCard.GoodType.Obsidian, 3);
        put(JaipurCard.GoodType.Diamonds, 2);
        put(JaipurCard.GoodType.Gold, 2);
        put(JaipurCard.GoodType.Silver, 2);
        put(JaipurCard.GoodType.Cloth, 1);
        put(JaipurCard.GoodType.Spice, 1);
        put(JaipurCard.GoodType.Leather, 1);
    }};
    Map<Integer, Integer[]> bonusTokensAvailable = new HashMap<Integer, Integer[]>() {{
        put(3, new Integer[]{1, 1, 2, 2, 2, 3, 3});
        put(4, new Integer[]{4, 4, 5, 5, 6, 6});
        put(5, new Integer[]{8, 8, 9, 10, 10});
    }};

    int nPointsMostCamels = 5;
    int nGoodTokensEmptyRoundEnd = 3;
    int nRoundsWinForGameWin = 2;
    Map<JaipurCard.GoodType, Integer[]> goodTokensProgression = new HashMap<>() {{
        put(JaipurCard.GoodType.Obsidian, new Integer[]{6, 6, 6, 8, 8});
        put(JaipurCard.GoodType.Diamonds, new Integer[]{5, 5, 5, 7, 7});
        put(JaipurCard.GoodType.Gold, new Integer[]{5, 5, 5, 6, 6});
        put(JaipurCard.GoodType.Silver, new Integer[]{5, 5, 5, 5, 5});
        put(JaipurCard.GoodType.Cloth, new Integer[]{1, 1, 2, 2, 3, 3, 5});
        put(JaipurCard.GoodType.Spice, new Integer[]{1, 1, 2, 2, 3, 3, 5});
        put(JaipurCard.GoodType.Leather, new Integer[]{1, 1, 1, 1, 1, 1, 2, 3, 4});
    }};
    int handLimit = 7;
    int nCardsInHandAtStart = 5;
    int marketSize = 5;
    int nCamelsInMarketAtStart = 3;
    Map<JaipurCard.GoodType, Integer> drawDeckCards = new HashMap<>() {{
        put(JaipurCard.GoodType.Obsidian, 6);
        put(JaipurCard.GoodType.Diamonds, 6);
        put(JaipurCard.GoodType.Gold, 6);
        put(JaipurCard.GoodType.Silver, 6);
        put(JaipurCard.GoodType.Cloth, 8);
        put(JaipurCard.GoodType.Spice, 8);
        put(JaipurCard.GoodType.Leather, 10);
        put(JaipurCard.GoodType.Camel, 11);
    }};

    public JaipurParameters() {
        super();
    }

    // Copy constructor
    private JaipurParameters(JaipurParameters jaipurParameters) {
        super();
        this.goodNCardsMinimumSell = new HashMap<>(jaipurParameters.getGoodNCardsMinimumSell());
        this.bonusTokensAvailable = new HashMap<>();
        for (int n : jaipurParameters.getBonusTokensAvailable().keySet()) {
            this.bonusTokensAvailable.put(n, jaipurParameters.getBonusTokensAvailable().get(n).clone());
        }
        this.nPointsMostCamels = jaipurParameters.getNPointsMostCamels();
        this.nGoodTokensEmptyRoundEnd = jaipurParameters.getNGoodTokensEmptyGameEnd();
        this.nRoundsWinForGameWin = jaipurParameters.getNRoundsWinForGameWin();
        this.goodTokensProgression = new HashMap<>();
        for (JaipurCard.GoodType gt : jaipurParameters.getGoodTokensProgression().keySet()) {
            this.goodTokensProgression.put(gt, jaipurParameters.getGoodTokensProgression().get(gt).clone());
        }
    }

    public Map<JaipurCard.GoodType, Integer> getGoodNCardsMinimumSell() {
        return goodNCardsMinimumSell;
    }

    public Map<Integer, Integer[]> getBonusTokensAvailable() {
        return bonusTokensAvailable;
    }

    public int getNPointsMostCamels() {
        return nPointsMostCamels;
    }

    public int getNGoodTokensEmptyGameEnd() {
        return nGoodTokensEmptyRoundEnd;
    }

    public int getNRoundsWinForGameWin() {
        return nRoundsWinForGameWin;
    }

    public Map<JaipurCard.GoodType, Integer[]> getGoodTokensProgression() {
        return goodTokensProgression;
    }

    public int getHandLimit() {
        return handLimit;
    }

    public int getNCardsInHandAtStart() {
        return nCardsInHandAtStart;
    }

    public int getMarketSize() {
        return marketSize;
    }

    public int getNCamelsInMarketAtStart() {
        return nCamelsInMarketAtStart;
    }

    public Map<JaipurCard.GoodType, Integer> getDrawDeckCards() {
        return drawDeckCards;
    }

    @Override
    protected AbstractParameters _copy() {
        return new JaipurParameters(this);
    }

    @Override
    public boolean _equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaipurParameters that = (JaipurParameters) o;
        return nPointsMostCamels == that.nPointsMostCamels && nGoodTokensEmptyRoundEnd == that.nGoodTokensEmptyRoundEnd && nRoundsWinForGameWin == that.nRoundsWinForGameWin && handLimit == that.handLimit && nCardsInHandAtStart == that.nCardsInHandAtStart && marketSize == that.marketSize && nCamelsInMarketAtStart == that.nCamelsInMarketAtStart && Objects.equals(goodNCardsMinimumSell, that.goodNCardsMinimumSell) && Objects.equals(bonusTokensAvailable, that.bonusTokensAvailable) && Objects.equals(goodTokensProgression, that.goodTokensProgression) && Objects.equals(drawDeckCards, that.drawDeckCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), goodNCardsMinimumSell, bonusTokensAvailable, nPointsMostCamels, nGoodTokensEmptyRoundEnd, nRoundsWinForGameWin, goodTokensProgression, handLimit, nCardsInHandAtStart, marketSize, nCamelsInMarketAtStart, drawDeckCards);
    }
}
