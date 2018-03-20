package suivisportifs.v1;

public enum Sport {
  Null,
  Football,
  BasketBall,
  Tennis,
  Rugby,
  Rallye,
  HandBall;
  
  static Sport getSportByInt(int i) {
    switch (i) {
      case 0:
        return Sport.Football;
      case 1:
        return Sport.BasketBall;
      case 2:
	return Sport.Tennis;
      case 3:
	return Sport.Rugby;
      case 4:
	return Sport.Rallye;
      case 5:
	return Sport.HandBall;
      default:
        return Sport.Null;
    }
  }

  static int getIntBySport(Sport i) {
    switch (i) {
      case Football:
        return 0;
      case BasketBall:
        return 1;
      case Tennis:
	return 2;
      case Rugby:
	return 3;
      case Rallye:
	return 4;
      case HandBall:
	return 5;
      default:
        return -1;
    }
  }
}
