<script lang="ts">
  import { onMount } from 'svelte';
  import type { Parada } from '../lib/api';

  export let paradas: Parada[] = [];

  let mapEl: HTMLElement;

  const TIPO_COLOR: Record<string, string> = {
    VADO: '#1a6fa8',
    DESCANSO: '#5a8a4a',
    HITO: '#c9a84c',
    ENTRADA_ALDEA: '#8b1a1a',
  };

  onMount(async () => {
    const L = (await import('leaflet')).default;
    await import('leaflet/dist/leaflet.css');

    const map = L.map(mapEl).setView([37.05, -6.4], 9);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '© <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>',
      maxZoom: 18,
    }).addTo(map);

    for (const parada of paradas) {
      const color = TIPO_COLOR[parada.tipo] ?? '#666';
      const marker = L.circleMarker([parada.latitud, parada.longitud], {
        radius: 8,
        fillColor: color,
        color: '#fff',
        weight: 2,
        opacity: 1,
        fillOpacity: 0.9,
      }).addTo(map);

      marker.bindPopup(`
        <strong>${parada.nombre}</strong><br/>
        <em>${parada.tipo}</em><br/>
        ${parada.descripcion ? `<p style="margin-top:4px;font-size:0.85rem">${parada.descripcion}</p>` : ''}
      `);
    }

    const coords = paradas
      .filter(p => p.latitud && p.longitud)
      .map(p => [p.latitud, p.longitud] as [number, number]);

    if (coords.length > 0) {
      map.fitBounds(L.latLngBounds(coords), { padding: [30, 30] });
    }
  });
</script>

<div bind:this={mapEl} class="mapa"></div>

<style>
  .mapa {
    height: 500px;
    width: 100%;
    border-radius: var(--radius);
    border: 1px solid var(--color-border);
    z-index: 0;
  }
</style>
