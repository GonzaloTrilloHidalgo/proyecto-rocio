/** Algoritmo de Meeus/Jones/Butcher para la Pascua gregoriana */
export function calcularPascua(year: number): Date {
  const a = year % 19;
  const b = Math.floor(year / 100);
  const c = year % 100;
  const d = Math.floor(b / 4);
  const e = b % 4;
  const f = Math.floor((b + 8) / 25);
  const g = Math.floor((b - f + 1) / 3);
  const h = (19 * a + b - d - g + 15) % 30;
  const i = Math.floor(c / 4);
  const k = c % 4;
  const l = (32 + 2 * e + 2 * i - h - k) % 7;
  const m = Math.floor((a + 11 * h + 22 * l) / 451);
  const month = Math.floor((h + l - 7 * m + 114) / 31);
  const day = ((h + l - 7 * m + 114) % 31) + 1;
  return new Date(year, month - 1, day);
}

export function calcularPentecostes(year: number): Date {
  const pascua = calcularPascua(year);
  const p = new Date(pascua);
  p.setDate(p.getDate() + 49);
  return p;
}

export function proximaRomeria(): { anio: number; pentecostes: Date; diasRestantes: number } {
  const hoy = new Date();
  hoy.setHours(0, 0, 0, 0);
  let anio = hoy.getFullYear();
  let pentecostes = calcularPentecostes(anio);
  if (pentecostes <= hoy) {
    anio++;
    pentecostes = calcularPentecostes(anio);
  }
  const diasRestantes = Math.ceil((pentecostes.getTime() - hoy.getTime()) / 86_400_000);
  return { anio, pentecostes, diasRestantes };
}
