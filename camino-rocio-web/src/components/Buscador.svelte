<script lang="ts">
  import type { Hermandad } from '../lib/api';

  export let hermandades: Hermandad[] = [];
  export let provincias: string[] = [];

  let q = '';
  let provinciaFiltro = '';
  let categoriaFiltro = '';

  $: filtradas = hermandades.filter(h => {
    const matchQ = !q || h.nombre.toLowerCase().includes(q.toLowerCase()) ||
                   (h.localidad ?? '').toLowerCase().includes(q.toLowerCase());
    const matchProv = !provinciaFiltro || h.provincia === provinciaFiltro;
    const matchCat = !categoriaFiltro || h.categoria === categoriaFiltro;
    return matchQ && matchProv && matchCat;
  });
</script>

<section class="buscador-wrapper">
  <div class="filtros">
    <input
      type="search"
      placeholder="Buscar hermandad o localidad..."
      bind:value={q}
    />
    <select bind:value={provinciaFiltro}>
      <option value="">Todas las provincias</option>
      {#each provincias as prov}
        <option value={prov}>{prov}</option>
      {/each}
    </select>
    <select bind:value={categoriaFiltro}>
      <option value="">Todas las categorías</option>
      <option value="FILIAL">Filiales</option>
      <option value="AGREGADA">Agregadas</option>
      <option value="CULTO">Culto</option>
    </select>
  </div>

  <p class="resultados-count">{filtradas.length} hermandad{filtradas.length !== 1 ? 'es' : ''}</p>

  <div class="grid">
    {#each filtradas as h (h.id)}
      <a href={`/hermandades/${h.id}`} class="card">
        <span class="card-orden">#{h.numeroOrden ?? '—'}</span>
        <h3>{h.nombre}</h3>
        {#if h.localidad}
          <p class="card-lugar">{h.localidad}{h.provincia ? ` · ${h.provincia}` : ''}</p>
        {/if}
        <span class="badge {h.categoria.toLowerCase()}">{h.categoria}</span>
      </a>
    {/each}
  </div>
</section>

<style>
  .buscador-wrapper {
    margin-top: 1.5rem;
  }

  .filtros {
    display: flex;
    gap: 0.75rem;
    flex-wrap: wrap;
    margin-bottom: 1rem;
  }

  input, select {
    padding: 0.5rem 0.75rem;
    border: 1px solid var(--color-border);
    border-radius: var(--radius);
    font-size: 0.95rem;
    background: #fff;
    flex: 1;
    min-width: 160px;
  }

  input:focus, select:focus {
    outline: 2px solid var(--color-primary);
    outline-offset: 1px;
  }

  .resultados-count {
    font-size: 0.85rem;
    color: var(--color-muted);
    margin-bottom: 1rem;
  }

  .grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(260px, 1fr));
    gap: 1rem;
  }

  .card {
    display: block;
    background: #fff;
    border: 1px solid var(--color-border);
    border-radius: var(--radius);
    padding: 1.1rem 1.25rem;
    box-shadow: var(--shadow);
    transition: transform 0.15s, box-shadow 0.15s;
  }

  .card:hover {
    transform: translateY(-2px);
    box-shadow: 0 4px 16px rgba(0,0,0,0.12);
    text-decoration: none;
  }

  .card-orden {
    font-size: 0.78rem;
    color: var(--color-muted);
    font-weight: 600;
  }

  .card h3 {
    font-size: 1rem;
    margin: 0.2rem 0 0.3rem;
    color: var(--color-text);
    font-family: var(--font-serif);
  }

  .card-lugar {
    font-size: 0.85rem;
    color: var(--color-muted);
    margin-bottom: 0.5rem;
  }

  .badge { font-size: 0.68rem; }
  .badge.filial   { background: var(--color-primary); color: #fff; }
  .badge.agregada { background: #5a7fa0; color: #fff; }
  .badge.culto    { background: #6a8a5a; color: #fff; }
</style>
