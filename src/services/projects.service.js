const path = import.meta.env.BASE_URL + 'data/'

export async function getAllProjects() {
    try {
        const response = await fetch(path + 'projects.json');
        return await response.json();
    } catch (e) {
        throw e
    }
}
export async function getAllExperiences() {
    try {
        const response = await fetch(path + 'experiences.json');
        return await response.json();
    } catch (e) {
        throw e
    }
}