from sqlalchemy.ext.asyncio import AsyncEngine, create_async_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.asyncio import async_sessionmaker

DATABASE_URL = "postgresql+asyncpg://postgres:postgres@db:5432/appdb"

engine: AsyncEngine = create_async_engine(DATABASE_URL, echo=False, future=True)
async_session_factory = async_sessionmaker(engine, expire_on_commit=False)

async def get_db():
    async with async_session_factory() as session:
        yield session
