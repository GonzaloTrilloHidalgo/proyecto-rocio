const API_BASE = import.meta.env.PUBLIC_API_URL ?? 'http://localhost:8080';

export interface Hermandad {
  id: number;
  nombre: string;
  numeroOrden: number | null;
  provincia: string | null;
  localidad: string | null;
  madrina: string | null;
  anioFundacion: number | null;
  categoria: 'FILIAL' | 'AGREGADA' | 'CULTO';
  latitud: number | null;
  longitud: number | null;
  web: string | null;
}

export interface Parada {
  id: number;
  nombre: string;
  descripcion: string | null;
  latitud: number;
  longitud: number;
  ordenEnCamino: number;
  tipo: 'VADO' | 'DESCANSO' | 'HITO' | 'ENTRADA_ALDEA';
}

export interface RomeriaInfo {
  anio: number;
  domingoPentecostes: string;
  lunesPentecostes: string;
  diasRestantes: number;
}

async function get<T>(path: string): Promise<T> {
  const res = await fetch(`${API_BASE}${path}`);
  if (!res.ok) throw new Error(`API error ${res.status}: ${path}`);
  return res.json();
}

export const api = {
  hermandades: (params?: Record<string, string>) => {
    const qs = params ? '?' + new URLSearchParams(params).toString() : '';
    return get<Hermandad[]>(`/api/hermandades${qs}`);
  },
  hermandad: (id: number) => get<Hermandad>(`/api/hermandades/${id}`),
  provincias: () => get<string[]>('/api/provincias'),
  paradas: () => get<Parada[]>('/api/paradas'),
  parada: (id: number) => get<Parada>(`/api/paradas/${id}`),
  romeria: () => get<RomeriaInfo>('/api/romeria/proxima'),
};
