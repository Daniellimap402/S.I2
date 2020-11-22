<template>
  <div>
    <nav class="navbar navbar-dark bg-dark">
     <a class="navbar-brand" href="#/home">Home</a>
     <h2>EASINESS</h2>
     <a class="navbar-brand" href="#/games">Games</a>
    </nav>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >

      <b-carousel-slide
        caption="Alien Isolation"
        text="“The game the Alien series has always deserved” 93% – PCGAMER."
        img-src="https://images6.alphacoders.com/543/thumb-1920-543182.jpg"
      >
        Descubra o verdadeiro significado do medo em Alien: Isolation, um horror
        de sobrevivência ambientado em uma atmosfera de medo constante e perigo
        mortal.
      </b-carousel-slide>

      <b-carousel-slide
        img-src="https://i.pinimg.com/originals/9f/3c/9e/9f3c9e90afbe301f43cb3a1d90751642.jpg"
      >
      </b-carousel-slide>

      <b-carousel-slide
        img-src="https://images8.alphacoders.com/594/thumb-1920-594648.jpg"
      ></b-carousel-slide>

      <b-carousel-slide>
        <template #img>
          <img
            class="d-block img-fluid w-100"
            width="1024"
            height="480"
            src="https://4.bp.blogspot.com/-E6FCm_KR-bo/VT6LsmhjcrI/AAAAAAAABbw/DIwbhzm2tlk/s1600/11128708_972366936116294_2555836273043465137_o.jpg"
            alt="image slot"
          />
        </template>
      </b-carousel-slide>

      <b-carousel-slide caption="Easiness" img-blank img-alt="Blank image">
        <p>
          A melhor loja de jogos, feita pra você, com diversos jogos e estilos
          de jogos como por exemplo Gta v, Alien Isolation, Fallout New Vegas,
          Resident evil, e muito mais.
        </p>
      </b-carousel-slide>
    </b-carousel>
  </div>
</template>