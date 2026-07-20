from pydantic import BaseModel


class HabitSuggestion(BaseModel):
    id: int
    text: str
    category: str
