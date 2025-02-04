import reflex as rx

from .pages.buscadores import buscadores
from .pages.redes_sociales import redesSociales
from .pages.index import index

class State(rx.State):
    pass

app = rx.App()