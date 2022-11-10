export interface Lab {
  id: number | null;
  name: string;
  x: number;
  y: number | null;
  creationDate: string | null;
  minimalPoint: number;
  personalQualitiesMaximum: number;
  difficulty: string;
  discipline: Discipline;
}

export interface LabDto {
  name: string;
  x: number;
  y: number | null;
  minimalPoint: number;
  personalQualitiesMaximum: number;
  difficulty: string;
  disciplineName: string;
}

export function LabMapperDTO(lab: Lab, disciplineName: string): LabDto {
  return {
    name: lab.name,
    x: lab.x,
    y: lab.y,
    minimalPoint: lab.minimalPoint,
    personalQualitiesMaximum: lab.personalQualitiesMaximum,
    difficulty: lab.difficulty,
    disciplineName
  }
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

export const DifficultyTypeMapper: Record<DifficultyType, string> = {
  [DifficultyType.VERY_EASY]: 'very easy',
  [DifficultyType.NORMAL]: 'normal',
  [DifficultyType.VERY_HARD]: 'very hard',
  [DifficultyType.IMPOSSIBLE]: 'impossible',
  [DifficultyType.INSANE]: 'insane',
}
