import reflex as rx

class FormState(rx.State):
    selected_option: str = ""

@rx.page(
    route="/",
    title = "Formulario de registro - Mi web",
    description="Página de inicio"
)
def index() -> rx.Component:
    return rx.form(
        rx.vstack(
            rx.text(
                "Formulario de registro",
                size="8"
            ),
            rx.hstack(
                rx.text("Nombre:"),
                rx.input(
                    placeholder="nombre",
                    name="name",
                    type="text",
                    id="nombre",
                    max_length=50
                )
            ),
            rx.hstack(
                rx.text("Apellidos:"),
                rx.input(
                    placeholder="apellidos",
                    name="lastname",
                    type="text",
                    id="apellidos",
                    max_length=50
                )
            ),
            rx.hstack(
                rx.text("Sexo:"),
                rx.vstack(
                    rx.radio_group(
                        ["hombre", "mujer"],
                        id="radio_group",
                        on_change=FormState.set_selected_option,
                    ),
                    rx.text(FormState.selected_option, id="radioSelect", style={"visibility": "visible"}),
                ),
            ),
            rx.hstack(
                rx.text("Email:"),
                rx.input(
                    placeholder="email@mail.com",
                    name="email",
                    type="text",
                    id="email"
                )
            ),
            rx.checkbox(
                text="Deseo recibir información sobre novedades y ofertas",
                id="check-offers",
                checked=True
            ),
            rx.checkbox(
                text="Declaro haber leido y aceptar las condiciones generales del programa y la normativa sobre protección de datos",
                id="check-terms"
            ),
            rx.button(
                "Enviar",
                id="btSend"
            ),
            padding="20px"
        )
    )

# app = rx.App()