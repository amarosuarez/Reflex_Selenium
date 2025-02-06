import reflex as rx

class FormState(rx.State):
    selected_option: str = ""

@rx.page(
    route="/",
    title = "Index",
    description="Página de inicio"
)
def index() -> rx.Component:
    return rx.form(
        rx.vstack(
            rx.hstack(
                rx.text("Nombre:"),
                rx.input(
                    placeholder="nombre",
                    name="name",
                    type="text",
                    id="nombre"
                )
            ),
            rx.hstack(
                rx.text("Apellidos:"),
                rx.input(
                    placeholder="apellidos",
                    name="lastname",
                    type="text",
                    id="apellidos"
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
        )
    )

# app = rx.App()