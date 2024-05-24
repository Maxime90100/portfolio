export async function getAllProjects() {
    try {
        const response = await fetch(`${import.meta.env.BASE_URL}public/data/projects.json`);
        return await response.json();
    } catch (e) {
        throw e
    }
}

export async function getProjectsTags(){
    try{
        const projects = await getAllProjects()
        const tags = projects.flatMap(project => project.tags);
        return [...new Set(tags)];
    }catch (e) {
        throw e
    }
}