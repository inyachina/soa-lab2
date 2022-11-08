export interface Lab {
  id: number | null;
  name: string;
  x: number;
  y: number | null;
  creationDate: string;
  minimalPoint: number;
  personalQualitiesMaximum: number;
  difficulty: string;
  discipline: Discipline;
}

export interface Discipline {
  id?: number | null | undefined;
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
