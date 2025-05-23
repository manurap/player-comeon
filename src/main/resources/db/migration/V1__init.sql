-- Create Players Table
CREATE TABLE players (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Sessions Table
CREATE TABLE sessions (
    id UUID PRIMARY KEY,
    player_id INT REFERENCES players(id) ON DELETE CASCADE,
    login_time TIMESTAMP NOT NULL,
    logout_time TIMESTAMP,
    duration INT NOT NULL,
    session_active BOOLEAN DEFAULT TRUE
);

-- Create Indexes
CREATE INDEX idx_players_email ON players(email);
CREATE INDEX idx_sessions_player_id ON sessions(player_id);