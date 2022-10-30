export interface Lab {
  id: number | null;
  name: string;
  x: number;
  y: number | null;
  creationDate: string;
  minimalPoint: number;
  personalQualitiesMaximum: number;
  difficulty: DifficultyType;
  discipline: Discipline;
}

export interface Discipline {
  name: string;
  lectureHours: number;
  selfStudyHours: number;
}

export enum DifficultyType {
  VERY_EASY,
  NORMAL,
  VERY_HARD,
  IMPOSSIBLE,
  INSANE,
}

export const DifficultyTypeMapping = {
  [DifficultyType.VERY_EASY]: 'very easy',
  [DifficultyType.NORMAL]: 'normal',
  [DifficultyType.VERY_HARD]: 'very hard',
  [DifficultyType.IMPOSSIBLE]: 'impossible',
  [DifficultyType.INSANE]: 'insane',
}
