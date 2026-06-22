<script lang="ts">
  import { onMount, onDestroy } from 'svelte';
  import { proximaRomeria } from '../lib/computus';

  let dias = 0;
  let horas = 0;
  let minutos = 0;
  let segundos = 0;
  let anio = 0;
  let fechaStr = '';
  let interval: ReturnType<typeof setInterval>;

  function actualizar() {
    const { pentecostes, anio: a } = proximaRomeria();
    anio = a;
    fechaStr = pentecostes.toLocaleDateString('es-ES', { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' });

    const ahora = new Date();
    const diff = pentecostes.getTime() - ahora.getTime();
    if (diff <= 0) return;

    dias = Math.floor(diff / 86_400_000);
    horas = Math.floor((diff % 86_400_000) / 3_600_000);
    minutos = Math.floor((diff % 3_600_000) / 60_000);
    segundos = Math.floor((diff % 60_000) / 1_000);
  }

  onMount(() => {
    actualizar();
    interval = setInterval(actualizar, 1000);
  });

  onDestroy(() => clearInterval(interval));
</script>

<div class="countdown">
  <p class="countdown-label">Próxima romería · {anio}</p>
  <p class="countdown-date">{fechaStr}</p>
  <div class="countdown-units">
    <div class="unit">
      <span class="number">{String(dias).padStart(3, '0')}</span>
      <span class="label">días</span>
    </div>
    <span class="sep">:</span>
    <div class="unit">
      <span class="number">{String(horas).padStart(2, '0')}</span>
      <span class="label">horas</span>
    </div>
    <span class="sep">:</span>
    <div class="unit">
      <span class="number">{String(minutos).padStart(2, '0')}</span>
      <span class="label">min</span>
    </div>
    <span class="sep">:</span>
    <div class="unit">
      <span class="number">{String(segundos).padStart(2, '0')}</span>
      <span class="label">seg</span>
    </div>
  </div>
</div>

<style>
  .countdown {
    text-align: center;
    padding: 2rem;
  }

  .countdown-label {
    font-size: 0.85rem;
    text-transform: uppercase;
    letter-spacing: 0.1em;
    color: rgba(255,255,255,0.7);
    margin-bottom: 0.25rem;
  }

  .countdown-date {
    font-size: 1.05rem;
    color: rgba(255,255,255,0.9);
    margin-bottom: 1.5rem;
    text-transform: capitalize;
  }

  .countdown-units {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 0.5rem;
    flex-wrap: wrap;
  }

  .unit {
    display: flex;
    flex-direction: column;
    align-items: center;
    min-width: 70px;
  }

  .number {
    font-size: 2.8rem;
    font-weight: 700;
    font-variant-numeric: tabular-nums;
    color: #fff;
    line-height: 1;
  }

  .label {
    font-size: 0.7rem;
    text-transform: uppercase;
    letter-spacing: 0.08em;
    color: rgba(255,255,255,0.6);
    margin-top: 0.25rem;
  }

  .sep {
    font-size: 2rem;
    color: rgba(255,255,255,0.4);
    margin-bottom: 1rem;
  }
</style>
