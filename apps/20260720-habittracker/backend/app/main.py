from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from app.models import HabitSuggestion

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=['*'],
    allow_credentials=True,
    allow_methods=['*'],
    allow_headers=['*'],
)

SUGGESTIONS = [
    HabitSuggestion(id=1, text='Drink 8 glasses of water', category='health'),
    HabitSuggestion(id=2, text='Walk 20 minutes', category='fitness'),
    HabitSuggestion(id=3, text='Read 10 pages', category='study'),
]

@app.get('/health')
def health():
    return {'status': 'ok'}

@app.get('/suggestions', response_model=list[HabitSuggestion])
def suggestions():
    return SUGGESTIONS
